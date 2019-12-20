package com.fitchconnect.pages;

/**
 * Created by Miah Ashrafuzzaman.
 */
public class PageManager {

	private static PageManager instance;
	private HomePage home;
	private LoginPage login;
	private MemberPage member;

	private PageManager() {
	}

	public static PageManager getInstance() {
		return (instance == null) ? instance = new PageManager() : instance;
	}

	public HomePage getHome() {
		return (home == null) ? home = new HomePage() : home;
	}

	public LoginPage getLogin() {
		return (login == null) ? login = new LoginPage() : login;
	}

	public MemberPage getMember() {
		return (member == null) ? member = new MemberPage() : member;
	}

	public void closePages() {
		home = null;
		login = null;
		member = null;
	}
}
