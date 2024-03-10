package com.ipl.middleware.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipl.middleware.exception.ErrorMessageConstant;
import com.ipl.middleware.exception.ResponseEntityException;
import com.ipl.middleware.repository.BidRepository;
import com.ipl.middleware.repository.EmployeeRepository;
import com.ipl.middleware.repository.MatchRepository;
import com.ipl.middleware.dto.IplMatchBidDTO;
import com.ipl.middleware.modal.BiddingModal;
import com.ipl.middleware.modal.MatchModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class IplService {
    @Autowired
    MatchRepository matchRepository;

    @Autowired
    BidRepository bidRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public List<MatchModal> matchList() {
        return matchRepository.findAll();
    }

    public void postBid(IplMatchBidDTO iplMatchBidDTO) {
        BiddingModal biddingModal = bidRepository.findByUserAndMatchId
                (iplMatchBidDTO.getUser(), iplMatchBidDTO.getMatchId());
        Optional.ofNullable(employeeRepository.findByUserName(iplMatchBidDTO.getUser()))
                .orElseThrow(() -> new ResponseEntityException(ErrorMessageConstant.USER_NOT_EXIST));
        MatchModal matchModal = matchRepository.findByMatchId(iplMatchBidDTO.getMatchId());
        Optional.ofNullable(matchModal)
                .orElseThrow(() -> new ResponseEntityException(ErrorMessageConstant.MATCH_NOT_EXIST));
        if (Optional.ofNullable(biddingModal).isPresent()) {
            throw new ResponseEntityException(ErrorMessageConstant.BID_EXIST);
        }
        if (Integer.parseInt(iplMatchBidDTO.getBidAmount()) < 30) {
            throw new ResponseEntityException(ErrorMessageConstant.INVALID_BID);
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
        LocalDateTime matchTime = LocalDateTime.parse(matchModal.getDate(), formatter);
        long diff = ChronoUnit.MINUTES.between(now, matchTime);
        System.out.println(now.isAfter(matchTime) + "[diff]" + diff);

        if (diff < 60 || now.isAfter(matchTime))
            throw new ResponseEntityException(ErrorMessageConstant.BID_TIME_OVER);
        ObjectMapper objectMapper = new ObjectMapper();
        BiddingModal biddingModalToBeSaved = objectMapper.convertValue(iplMatchBidDTO, BiddingModal.class);
        biddingModalToBeSaved.setBidTime(now.toString());
        bidRepository.save(biddingModalToBeSaved);
    }
}
