package com.leetcode.test15.stateMachine.validnumber;

public class Solution {

	public static void main(String[] args) {
		State s = State.INIT;
		System.out.println(s);
	}

	public boolean isNumber(String s) {
		StateMachine sm = new StateMachine();
		for(int i = 0; i < s.length() && sm.getState() != State.INVALID; i++) {
			sm.feed(s.charAt(i));
		}
		return sm.isValid();
	}

	enum State {
		INIT, DIGIT1, DOT_DIGIT, DOT_EMPYT, SIGN1, E, DIGIT2, SIGN2, DIGIT3, INVALID
	}

	class StateMachine {
		private State state;
		private char c;
		private boolean valid;

		public StateMachine() {
			state = State.INIT;
			valid = false;
		}

		public State getState() {
			return state;
		}

		public boolean isValid() {
			return valid;
		}

		public void feed(char c) {
			this.c = c;
			switch (state) {
			case INIT:
				if (isDot()) {
					state = State.DOT_EMPYT;
					valid = false;
				}
				else if (isDigit()) {
					state = State.DIGIT1;
					valid = true;
				}
				else if (isSign()) {
					state = State.SIGN1;
					valid = false;
					}
				else {
					state = State.INVALID;
					valid = false;
				}
				break;
			case DIGIT1:
				if (isDigit()) {
					valid = true;
				}
				else if (isDot()) {
					state = State.DOT_DIGIT;
					valid = true;
				}
				else if (isE()) {
					state = State.E;
					valid = false;
				}
				else {
					state = State.INVALID;
					valid = false;
				}
				break;
			case DOT_DIGIT:
				if (isDigit()) {
					state = State.DIGIT2;
					valid = true;
				} else if(isE()) {
					valid = false;
					state = State.E;
				}
				else {
					state = State.INVALID;
					valid = false;
				}
				break;
			case SIGN1:
				if (isDigit()) {
					state = State.DIGIT1;
					valid = true;
				}
				else if (isDot()) {
					state = State.DOT_EMPYT;
					valid = false;
				}
				else {
					state = State.INVALID;
					valid = false;
				}
				break;
			case E:
				if (isSign()) {
					state = State.SIGN2;
					valid = false;
				}
				else if (isDigit()) {
					state = State.DIGIT3;
					valid = true;
				}
				else {
					state = State.INVALID;
					valid = false;
				}
				break;
			case DIGIT2:
				if (isDigit()) {
					valid = true;
				}
				else if (isE()) {
					state = State.E;
					valid = false;
				}
				else {
					state = State.INVALID;
					valid = false;
				}
				break;
			case SIGN2:
				if (isDigit()) {
					state = State.DIGIT3;
					valid = true;
				}
				else {
					state = State.INVALID;
					valid = false;
				}
				break;
			case DIGIT3:
				if (isDigit()) {
					valid = true;
				}
				else {
					state = State.INVALID;
					valid = false;
				}
				break;
			case DOT_EMPYT:
				if (isDigit()) {
					state = State.DIGIT2;
					valid = true;
				}
				else {
					state = State.INVALID;
					valid = false;
				}
				break;
			case INVALID:
				break;
			}
		}

		private boolean isDigit() {
			return c >= '0' && c <= '9';
		}

		private boolean isE() {
			return c == 'e' || c == 'E';
		}

		private boolean isSign() {
			return c == '-' || c == '+';
		}

		private boolean isDot() {
			return c == '.';
		}
	}

}
