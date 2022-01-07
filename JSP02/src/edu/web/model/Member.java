package edu.web.model;

public class Member {
	// 멤버 변수(필드, 프로퍼티)
	private String memberId;
	private String memberPassword;
	private String memberEmail;
	
	// 생성자
	public Member() {}
	public Member(String memberId, String memberPassword, String memberEmail) {
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
	}
	
	// 메서드
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	@Override
	public String toString() {
		// String.format(format, args)
		// format: %s(string, 문자열), %d(digit, 정수), %f(floating point, 실수)
		return String.format("Member{memberId: %s, memberPassword: %s, memberEmail: %s}",
				this.memberId, this.memberPassword, this.memberEmail);
	}
}