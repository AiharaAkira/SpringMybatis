package com.mz.pj.sns;

import java.util.List;

import com.mz.pj.member.Member;

public interface SNSMapper {

	int getMsgCount(SNSSelector sSel);

	List<SNSMsg> getMsg(SNSSelector search);

	List<SNSReply> getReply(SNSMsg snsMsg);
	
	public abstract int deleteMsg(SNSMsg sm);
	public abstract int deleteReply(SNSReply sr);
	public abstract int updateMsg(SNSMsg sm);
	public abstract int writeMsg(SNSMsg sm);
	public abstract int writeReply(SNSReply sr);
	public abstract Integer getMsgCountByOwner(Member m);
	
	

}
