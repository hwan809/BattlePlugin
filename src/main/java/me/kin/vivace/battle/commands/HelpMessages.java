package me.kin.vivace.battle.commands;

import org.bukkit.ChatColor;

public enum HelpMessages {
    BATTLE_COMMAND(ChatColor.GOLD +
            "[ 배틀 플러그인 도움말 ]\n\n" +
            ChatColor.WHITE +
            "/배틀 시작 <이름>\n" +
            "/배틀 생성 <이름>\n" +
            "/배틀 삭제 <이름>\n" +
            "/배틀 목록\n" +
            "/배틀 종료\n" +
            "/배틀 위치 <로비,대기실>\n" +
            "\n\n" +
            "/배틀 설정 <이름> 기준점\n" +
            "/배틀 설정 <이름> 슬롯아이템\n" +
            "/배틀 스폰 생성 <이름> <B이름>\n" +
            "/배틀 스폰 삭제 <이름> <B이름>\n" +
            "/배틀 스폰 이동 <이름> <B이름>\n" +
            "/배틀 스폰 정보 <이름>\n" +
            "/배틀 관리 보관함 <닉네임>\n" +
            "/배틀 관리 추방  <닉네임>\n" +
            "/배틀 관리 초기화 <닉네임,전체>\n" +
            "/배틀 승리보상\n" +
            "/배틀 처치보상");

    private String helpMessage;

    private HelpMessages(String helpMessage) {
        this.helpMessage = helpMessage;
    }

    public String getHelpMessage() {
        return this.helpMessage;
    }
}
