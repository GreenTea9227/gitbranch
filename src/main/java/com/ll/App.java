package com.ll;


import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;

import java.util.HashMap;
import java.util.Map;

public class App {
    public void run() {
        System.out.println("== 명언앱 ==");

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        while (true) {
            System.out.print("명령) ");
            // trim() : 혹시 있을지 모를 좌우공백제거된 버전으로 주세요.
            String command = Container.getScanner().nextLine().trim();

            if (command.equals("종료")) {
                systemController.exit();

                break;
            } else if (command.equals("등록")) {
                wiseSayingController.write();
            } else if (command.equals("목록")) {
                wiseSayingController.list();
            } else if (command.startsWith("삭제")) {
                // 정리 시작

                String[] commandBits = command.split("\\?", 2);
                String actionCode = commandBits[0];
                Map<String, String> params = new HashMap<>();
                String[] paramsBits = commandBits[1].split("&");

                for (String paramStr : paramsBits) {
                    String[] paramStrBits = paramStr.split("=", 2);
                    String key = paramStrBits[0];
                    String value = paramStrBits[1];

                    params.put(key, value);
                }

                System.out.printf("actionCode : %s\n", actionCode);
                System.out.printf("params : %s\n", params);

                // 정리 끝

                wiseSayingController.remove();
            }
        }
    }
}
