package com.vinodborole.brainteasers.passballgame;

import java.util.ArrayList;
import java.util.List;

public class PassBallGame {

	class Player{
		 private int id;
		 private boolean hasBall;
		 private int times;
		 public Player(int id, boolean hasBall, int times){
			 this.id=id;
			 this.hasBall=hasBall;
			 this.times=times;
		 }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public boolean isHasBall() {
			return hasBall;
		}
		public void setHasBall(boolean hasBall) { 
			this.hasBall = hasBall;
		}
		public int getTimes() {
			return times;
		}
		public void setTimes(int times) {
			this.times = times;
		}
		public void increementTimes(){
			this.setTimes(this.getTimes()+1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(passCount(3, 3, 3));
	}
	
	public static int passCount(int input1,int input2,int input3)
	{
		if(!validateInputs(input1,input2,input3))
			return -1;
		PassBallGame passBallGame = new PassBallGame();
		List<Player> players = new ArrayList<Player>(); 
		for(int i=1;i<=input1;i++){
			Player player=null;
			if(i==1) 
				player = passBallGame.new Player(i, true, 1);	 
			else
				player = passBallGame.new Player(i, false, 0);
			players.add(player);
		}
		
		int passCount=0;
		int pos=0;
		int i=0;
		do{
			i=pos;
			if(players.get(i).getTimes()==input2){
				System.out.println("Player:"+players.get(i).getId()+" received maximum number of passes "+players.get(i).getTimes());
				break;
			}
			if(players.get(i).isHasBall()){
				if(players.get(i).getTimes()%2==0){
					players.get(i).setHasBall(false);
					pos = i-input3;
					if(pos < 0){
						pos = pos+input1;
					}else if(pos >= input1){
						pos = pos-input1;
					}
					System.out.println("Player "+players.get(i).getId()+" passes the ball to Player "+players.get(pos).getId());
					players.get(pos).setHasBall(true);
					players.get(pos).increementTimes();
				}else{
					
					players.get(i).setHasBall(false);
					pos = i+input3;
					if(pos>=input1){
					  pos = pos-input1;
					}
					System.out.println("Player "+players.get(i).getId()+" passes the ball to Player "+players.get(pos).getId());
					players.get(pos).setHasBall(true);
					players.get(pos).increementTimes();
				}
				
				passCount++;
				System.out.println("Pass count: "+passCount);
			}
		}while(true);
		
		return passCount;
	}

	private static boolean validateInputs(int input1, int input2, int input3) {
		boolean n = false,m = false,l=false;	
		
		if(input1 >=3 && input1 <= 1000)
			n=true;
		if(input2 >=3 && input2<= 1000)
			m=true;
		if(input3 > 0 && input3 < input1)
			l=true;
		
		if(n && m && l)
			return true;
		
		return false;
	}
	
}
