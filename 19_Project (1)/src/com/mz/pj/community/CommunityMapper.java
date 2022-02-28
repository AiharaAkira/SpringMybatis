package com.mz.pj.community;

import java.util.List;

import com.mz.pj.member.Member;

public interface CommunityMapper {
	public List<Member> getMember();
	public List<CommunityMsg> getMsg(Member m);
	public int deleteMsg(CommunityMsg cm);
	public int sendMsg(CommunityMsg cm);
}
