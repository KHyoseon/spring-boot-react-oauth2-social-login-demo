package com.websocket.chat.repo;

import com.websocket.chat.model.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@RequiredArgsConstructor
@Service
public class ChatRoomRepository {

    private Map<String, ChatRoom> chatRoomMap;

    @PostConstruct
    public void init(){
        chatRoomMap = new LinkedHashMap<>();
        chatRoomMap.put("1", createChatRoom("1번 서버"));
        chatRoomMap.put("2", createChatRoom("2번 서버"));
        chatRoomMap.put("3", createChatRoom("3번 서버"));
        chatRoomMap.put("4", createChatRoom("4번 서버"));
        chatRoomMap.put("5", createChatRoom("5번 서버"));
    }

    public List<ChatRoom> findAllRoom() {
        // 채팅방 생성순서 최근 순으로 반환
        List<ChatRoom> chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }

    public ChatRoom findRoomById(String id) {
        return chatRoomMap.get(id);
    }

    public ChatRoom createChatRoom(String name) {
        ChatRoom chatRoom = ChatRoom.create(name);
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }
}
