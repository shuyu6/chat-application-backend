package com.shuyu.chat.application.rest.service;

import com.shuyu.chat.application.domain.entity.ChatRoom;
import com.shuyu.chat.application.domain.entity.UserChatRoom;
import com.shuyu.chat.application.domain.entity.UserChatRoomId;
import com.shuyu.chat.application.domain.model.ChatMessageModel;
import com.shuyu.chat.application.domain.repository.JpaChatMessageRepository;
import com.shuyu.chat.application.domain.repository.JpaChatRoomRepository;
import com.shuyu.chat.application.domain.repository.JpaUserChatRoomRepository;
import com.shuyu.chat.application.rest.dto.ChatMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * =============================================================================
 * -----------------------------------------------------------------------------
 *
 * @author Shu Yu 22/6/2021
 * <p>
 * -----------------------------------------------------------------------------
 * =============================================================================
 **/
@Service
public class ChatRoomService {
    @Autowired
    private JpaUserChatRoomRepository userChatRoomRepository;

    @Autowired
    private JpaChatRoomRepository chatRoomRepository;

    @Autowired
    private JpaChatMessageRepository chatMessageRepository;

    // find chat room by sender id and receiver id
    public BigDecimal findChatRoomBySenderIdAndReceiverId(BigDecimal senderId, BigDecimal receiverId){
        if (senderId.equals(receiverId))
            return BigDecimal.ZERO;

        Optional<BigDecimal> chatRoomId = userChatRoomRepository.findChatRoomIdBySenderIdAndReceiverId(senderId, receiverId);
        if (chatRoomId.isPresent()){
            return chatRoomId.get();
        }else{
            var chatRoom = chatRoomRepository.save(new ChatRoom());
            var senderUserChatRoom = new UserChatRoom(new UserChatRoomId(chatRoom.getId(), senderId));
            var receiverUserChatRoom = new UserChatRoom(new UserChatRoomId(chatRoom.getId(), receiverId));

            userChatRoomRepository.save(senderUserChatRoom);
            userChatRoomRepository.save(receiverUserChatRoom);
            return chatRoom.getId();
        }
    }

    public ChatMessageDto retrieveChatHistoryByChatRoomIdAndPageSizeAndPageNo(BigDecimal chatRoomId, int pageSize, int pageNo){
        ChatMessageDto chatMessageDto = new ChatMessageDto();
        long totalRecord = chatMessageRepository.countByChatRoomId(chatRoomId);
        List<ChatMessageModel> listChatMessage =  chatMessageRepository.findChatMessageByChatRoomId(chatRoomId, PageRequest.of(pageNo, pageSize));

        chatMessageDto.setHasNext(totalRecord>((long) pageSize *(pageNo+1)));
        chatMessageDto.setTotalRecord(totalRecord);
        chatMessageDto.setMessageList(listChatMessage);
        return chatMessageDto;
    }
}
