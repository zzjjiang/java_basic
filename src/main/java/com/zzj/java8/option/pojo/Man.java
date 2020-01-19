package com.zzj.java8.option.pojo;

public class Man {

	private Godness god;

	public Man() {
	}

	public Man(Godness god) {
		this.god = god;
	}

	public Godness getGod() {
		return god;
	}

	public void setGod(Godness god) {
		this.god = god;
	}

	@Override
	public String toString() {
		return "Man [god=" + god + "]";
	}

}
