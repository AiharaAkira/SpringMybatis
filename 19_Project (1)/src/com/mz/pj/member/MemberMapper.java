package com.mz.pj.member;

public interface MemberMapper {

	public int join(Member m);
	
	public abstract int update(Member m);			
	public abstract int bye(Member m);

	public Member getMemberByID(Member m);
	public int getMemberNum(Member m);
	
	
	
	
	
}
