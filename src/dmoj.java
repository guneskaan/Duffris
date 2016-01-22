import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class dmoj extends JPanel implements ActionListener,KeyListener{
	static JFrame j=new JFrame();
	static boolean game=false;
	static boolean send=false;
	static int board[][]={	{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,0,0,0,0,0,0,0,0,0,0,2},
							{2,2,2,2,2,2,2,2,2,2,2,2}};
	
	static int p1x,p1y,p2x,p2y,p3x,p3y,p4x,p4y;
    static int currentpiece=1;
    static int shape=1;
    static int score=0;
    static boolean help=false;
	public static void main(String[]args){
	
		j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		dmoj p=new dmoj();
        j.add(p);
        j.setVisible(true);
        j.setSize(900,758);
        p.init();
        j.setBackground(Color.cyan);
        Timer t=new Timer(500,p);
        t.start();
	}
	public static void update(){
		gamecheck();
		if(game==true){
		lineclear();
		board[p1y][p1x]=0;
		board[p2y][p2x]=0;
		board[p3y][p3x]=0;
		board[p4y][p4x]=0;
		board[p1y+1][p1x]=1;
		board[p2y+1][p2x]=1;
		board[p3y+1][p3x]=1;
		board[p4y+1][p4x]=1;
		j.repaint();
		}
	}
	public void paintComponent(Graphics g){
		for(int a=2;a<board.length;a++){
			for(int b=0;b<board[0].length;b++){
				if(board[a][b]==0){
					g.setColor(Color.blue);
					g.fillRect((40*b), (40*a)-80, 40,40);
				}
				else if(board[a][b]==1){
					switch(currentpiece){
					case 1:
						g.setColor(Color.yellow);
						break;
					case 2:
						g.setColor(Color.red);
						break;
					case 3:
						g.setColor(Color.green);
						break;
					case 4:
						g.setColor(Color.orange);
						break;
					case 5:
						g.setColor(Color.cyan);
						break;
					case 6:
						g.setColor(Color.magenta);
						break;
					case 7:
						g.setColor(Color.pink);
						break;
					default:
						g.setColor(Color.black);
						break;
					}
					
					g.fillRect((40*b), (40*a)-80, 40,40);
					g.setColor(Color.black);
					g.drawRect((40*b), (40*a)-80, 40,40);
				}
				else if(board[a][b]==2){
					g.setColor(Color.gray);
					g.fillRect((40*b), (40*a)-80, 40,40);
					g.setColor(Color.black);
					g.drawRect((40*b), (40*a)-80, 40,40);
				}
				else if(board[a][b]==11){
					g.setColor(Color.yellow);
					g.fillRect((40*b), (40*a)-80, 40,40);
					g.setColor(Color.black);
					g.drawRect((40*b), (40*a)-80, 40,40);
				}
				else if(board[a][b]==12){
					g.setColor(Color.red);
					g.fillRect((40*b), (40*a)-80, 40,40);
					g.setColor(Color.black);
					g.drawRect((40*b), (40*a)-80, 40,40);
				}
				else if(board[a][b]==13){
					g.setColor(Color.green);
					g.fillRect((40*b), (40*a)-80, 40,40);
					g.setColor(Color.black);
					g.drawRect((40*b), (40*a)-80, 40,40);
				}
				else if(board[a][b]==14){
					g.setColor(Color.orange);
					g.fillRect((40*b), (40*a)-80, 40,40);
					g.setColor(Color.black);
					g.drawRect((40*b), (40*a)-80, 40,40);
				}
				else if(board[a][b]==15){
					g.setColor(Color.cyan);
					g.fillRect((40*b), (40*a)-80, 40,40);
					g.setColor(Color.black);
					g.drawRect((40*b), (40*a)-80, 40,40);
				}
				else if(board[a][b]==16){
					g.setColor(Color.magenta);
					g.fillRect((40*b), (40*a)-80, 40,40);
					g.setColor(Color.black);
					g.drawRect((40*b), (40*a)-80, 40,40);
				}
				else if(board[a][b]==17){
					g.setColor(Color.pink);
					g.fillRect((40*b), (40*a)-80, 40,40);
					g.setColor(Color.black);
					g.drawRect((40*b), (40*a)-80, 40,40);
				}
				else if(board[a][b]==18){
					g.setColor(Color.black);
					g.fillRect((40*b), (40*a)-80, 40,40);
					g.setColor(Color.black);
					g.drawRect((40*b), (40*a)-80, 40,40);
				}
			}
			
		}
		g.setColor(Color.black);
		g.setFont(new Font("Jokerman", Font.BOLD, 80));
		g.drawString("DUFFRIS", 500, 80);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		
		if(help==true){
			g.drawString("Down to rotate", 485, 660);
			g.drawString("Space to speed up", 485, 700);
			g.drawString("Left/Right to move", 485, 580);
		}
		if(game==false && score!=0){
			g.drawString("Game OVER!", 630, 390);
			g.drawString("Press SPACEBAR to restart", 580, 480);
		}
		g.drawString("press H to show/hide help", 670, 710);
		g.setFont(new Font("TimesRoman", Font.BOLD, 50));
		g.drawString("Score:", 630, 210);
		g.drawString(""+score, 680, 300);
		
		
		
	}
    public void init(){
        j.setFocusable(true);
        j.addKeyListener(this);
    }
	@Override
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		if(key==KeyEvent.VK_H){
			if(help==false)help=true;
			else help=false;
			j.repaint();
		}
		if(key==KeyEvent.VK_SPACE && game==false){
			restart();
			longpiece();
			game=true;
			j.repaint();
			board[1][0]=2;
		}
		if(key==KeyEvent.VK_SPACE && game==true && (board[p1y+2][p1x]==1 || board[p1y+2][p1x]==0) && (board[p2y+2][p2x]==0 || board[p2y+2][p2x]==1) && (board[p3y+2][p3x]==0 || board[p3y+2][p3x]==1) && (board[p4y+2][p4x]==0 || board[p4y+2][p4x]==1)){
			p1y++;
			p2y++;
			p3y++;
			p4y++;
			update();
		}
		if(key==KeyEvent.VK_RIGHT && (board[p1y+1][p1x+1]==1 || board[p1y+1][p1x+1]==0) && (board[p2y+1][p2x+1]==1 || board[p2y+1][p2x+1]==0) && (board[p3y+1][p3x+1]==0 || board[p3y+1][p3x+1]==1) && (board[p4y+1][p4x+1]==0 || board[p4y+1][p4x+1]==1)){
		    board[p1y+1][p1x]=0;
			board[p2y+1][p2x]=0;
			board[p3y+1][p3x]=0;
		    board[p4y+1][p4x]=0;
			p1x++;
			p2x++;
			p3x++;
			p4x++;
			update();
		  
		}
		if(key==KeyEvent.VK_LEFT && (board[p1y+1][p1x-1]==1 || board[p1y+1][p1x-1]==0) && (board[p2y+1][p2x-1]==1 || board[p2y+1][p2x-1]==0) && (board[p3y+1][p3x-1]==0 || board[p3y+1][p3x-1]==1) && (board[p4y+1][p4x-1]==0 || board[p4y+1][p4x-1]==1)){
		    board[p1y+1][p1x]=0;
			board[p2y+1][p2x]=0;
			board[p3y+1][p3x]=0;
		    board[p4y+1][p4x]=0;
			p1x--;	
			p2x--;
			p3x--;
			p4x--;
			update();
		
		}
		if(key==KeyEvent.VK_DOWN){
			if(currentpiece==1){
				if(shape==1){	
					if(board[p1y+1][p1x-1]==0 && board[p3y-1][p3x+1]==0 && board[p4y-2][p4x+2]==0){
						board[p1y+1][p1x-1]=1;
						board[p3y-1][p3x+1]=1;
						board[p4y-2][p4x+2]=1;
						board[p1y+1][p1x]=0;
						board[p3y+1][p3x]=0;
						board[p4y+1][p4x]=0;
						p1y=p1y+1;
						p1x=p1x-1;
						p3y=p3y-1;
						p3x=p3x+1;
						p4y=p4y-2;
						p4x=p4x+2;
						update();
						shape=2;
					}
				}
				else if(shape==2){
					if((board[p1y-1][p1x+1]==0 || board[p1y-1][p1x+1]==1 )&& (board[p3y+1][p3x-1]==0 || board[p3y+1][p3x-1]==1)&& (board[p4y+2][p4x-2]==0 || board[p4y+2][p4x-2]==1)){
						board[p1y-1][p1x+1]=1;
						board[p3y+1][p3x-1]=1;
						board[p4y+2][p4x-2]=1;
						board[p1y+1][p1x]=0;
						board[p3y+1][p3x]=0;
						board[p4y+1][p4x]=0;
						p1y=p1y-1;
						p1x=p1x+1;
						p3y=p3y+1;
						p3x=p3x-1;
						p4y=p4y+2;
						p4x=p4x-2;
						update();
						shape=1;
					}
				}
				
			}
			else if(currentpiece==2){
			  if(shape==1){	
				if((board[p1y+1][p1x+1]==0 || board[p1y+1][p1x+1]==1 )&& (board[p3y-1][p3x-1]==0 || board[p3y-1][p3x-1]==1)&& (board[p4y+1][p4x+1]==0 || board[p4y+1][p4x+1]==1)){
					board[p4y][p4x-2]=1;
					board[p3y-1][p3x-1]=1;
					board[p1y+1][p1x+1]=1;
					board[p1y+1][p1x]=0;
					board[p3y+1][p3x]=0;
					board[p4y+1][p4x]=0; 
					p1x=p1x+1;
					p1y=p1y+1;
					p3y=p3y-1;
					p3x=p3x-1;
					p4y=p4y;
					p4x=p4x-2;
					update();
					shape=2;
				}
			  }
			  	else if(shape==2){	
					if((board[p1y-1][p1x+1]==0 || board[p1y-1][p1x+1]==1 )&& (board[p3y+1][p3x-1]==0 || board[p3y+1][p3x-1]==1)&& (board[p4y+2][p4x]==0 || board[p4y+2][p4x]==1)){
						board[p4y+2][p4x]=1;
						board[p3y+1][p3x-1]=1;
						board[p1y-1][p1x+1]=1;
						board[p1y+1][p1x]=0;
						board[p3y+1][p3x]=0;
						board[p4y+1][p4x]=0; 
						p1x=p1x+1;
						p1y=p1y-1;
						p3y=p3y+1;
						p3x=p3x-1;
						p4y=p4y+2;
						update();
						shape=3;
					}
				 }
				else if(shape==3){	
					if((board[p1y-1][p1x-1]==0 || board[p1y-1][p1x-1]==1 )&& (board[p3y+1][p3x+1]==0 || board[p3y+1][p3x+1]==1)&& (board[p4y][p4x+2]==0 || board[p4y][p4x+2]==1)){
						board[p4y][p4x+2]=1;
						board[p3y+1][p3x+1]=1;
						board[p1y-1][p1x-1]=1;
						board[p1y+1][p1x]=0;
						board[p3y+1][p3x]=0;
						board[p4y+1][p4x]=0; 
						p1x=p1x-1;
						p1y=p1y-1;
						p3y=p3y+1;
						p3x=p3x+1;
						p4x=p4x+2;
						update();
						shape=4;
					}
				 }
				else if(shape==4){	
					if((board[p1y+1][p1x-1]==0 || board[p1y+1][p1x-1]==1 )&& (board[p3y-1][p3x+1]==0 || board[p3y-1][p3x+1]==1)&& (board[p4y-2][p4x]==0 || board[p4y-2][p4x]==1)){
						board[p4y-2][p4x]=1;
						board[p3y-1][p3x+1]=1;
						board[p1y+1][p1x-1]=1;
						board[p1y+1][p1x]=0;
						board[p3y+1][p3x]=0;
						board[p4y+1][p4x]=0; 
						p1x=p1x-1;
						p1y=p1y+1;
						p3y=p3y-1;
						p3x=p3x+1;
						p4y=p4y-2;
						update();
						shape=1;
					}
				 }
			}
			else if(currentpiece==3){
				  if(shape==1){	
					if((board[p1y+2][p1x]==0 || board[p1y+2][p1x]==1 )&& (board[p2y+1][p2x+1]==0 || board[p2y+1][p2x+1]==1)&& (board[p4y-1][p4x-1]==0 || board[p4y-1][p4x-1]==1)){
						board[p4y-1][p4x-1]=1;
						board[p2y+1][p2x+1]=1;
						board[p1y+2][p1x]=1;
						board[p1y+1][p1x]=0;
						board[p2y+1][p2x]=0;
						board[p4y+1][p4x]=0; 
						p1x=p1x;
						p1y=p1y+2;
						p2y=p2y+1;
						p2x=p2x+1;
						p4y=p4y-1;
						p4x=p4x-1;
						update();
						shape=2;
					}
				  }
				  	else if(shape==2){	
				  		if((board[p1y][p1x+2]==0 || board[p1y][p1x+2]==1 )&& (board[p2y-1][p2x+1]==0 || board[p2y-1][p2x+1]==1)&& (board[p4y+1][p4x-1]==0 || board[p4y+1][p4x-1]==1)){
							board[p4y+1][p4x-1]=1;
							board[p2y-1][p2x+1]=1;
							board[p1y][p1x+2]=1;
							board[p1y+1][p1x]=0;
							board[p2y+1][p2x]=0;
							board[p4y+1][p4x]=0; 
							p1x=p1x+2;
							p1y=p1y;
							p2y=p2y-1;
							p2x=p2x+1;
							p4y=p4y+1;
							p4x=p4x-1;
							update();
							shape=3;
						}
					 }
					else if(shape==3){	
						if((board[p1y-2][p1x]==0 || board[p1y-2][p1x]==1 )&& (board[p2y-1][p2x-1]==0 || board[p2y-1][p2x-1]==1)&& (board[p4y+1][p4x+1]==0 || board[p4y+1][p4x+1]==1)){
							board[p4y+1][p4x+1]=1;
							board[p2y-1][p2x-1]=1;
							board[p1y-2][p1x]=1;
							board[p1y+1][p1x]=0;
							board[p2y+1][p2x]=0;
							board[p4y+1][p4x]=0; 
							p1x=p1x;
							p1y=p1y-2;
							p2y=p2y-1;
							p2x=p2x-1;
							p4y=p4y+1;
							p4x=p4x+1;
							update();
							shape=4;
						}
					 }
					else if(shape==4){	
						if((board[p1y][p1x-2]==0 || board[p1y][p1x-2]==1 )&& (board[p2y+1][p2x-1]==0 || board[p2y+1][p2x-1]==1)&& (board[p4y-1][p4x+1]==0 || board[p4y-1][p4x+1]==1)){
							board[p4y-1][p4x+1]=1;
							board[p2y+1][p2x-1]=1;
							board[p1y][p1x-2]=1;
							board[p1y+1][p1x]=0;
							board[p2y+1][p2x]=0;
							board[p4y+1][p4x]=0; 
							p1x=p1x-2;
							p1y=p1y;
							p2y=p2y+1;
							p2x=p2x-1;
							p4y=p4y-1;
							p4x=p4x+1;
							update();
							shape=1;
						}
					 }
				}
			else if(currentpiece==5){
				 if(shape==1){	
						if((board[p1y+1][p1x+1]==0 || board[p1y+1][p1x+1]==1 )&& (board[p3y+1][p3x-1]==0 || board[p3y+1][p3x-1]==1)&& (board[p4y][p4x-2]==0 || board[p4y][p4x-2]==1)){
							board[p4y][p4x-2]=1;
							board[p3y+1][p3x-1]=1;
							board[p1y+1][p1x+1]=1;
							board[p1y+1][p1x]=0;
							board[p2y+1][p2x]=0;
							board[p4y+1][p4x]=0; 
							p1x=p1x+1;
							p1y=p1y+1;
							p3y=p3y+1;
							p3x=p3x-1;
							p4y=p4y;
							p4x=p4x-2;
							update();
							shape=2;
						}
					  }
				 else if(shape==2){	
						if((board[p1y-1][p1x-1]==0 || board[p1y-1][p1x-1]==1 )&& (board[p3y-1][p3x+1]==0 || board[p3y-1][p3x+1]==1)&& (board[p4y][p4x+2]==0 || board[p4y][p4x+2]==1)){
							board[p4y][p4x+2]=1;
							board[p3y-1][p3x+1]=1;
							board[p1y-1][p1x-1]=1;
							board[p1y+1][p1x]=0;
							board[p2y+1][p2x]=0;
							board[p4y+1][p4x]=0; 
							p1x=p1x-1;
							p1y=p1y-1;
							p3y=p3y-1;
							p3x=p3x+1;
							p4y=p4y;
							p4x=p4x+2;
							update();
							shape=1;
						}
					  }
				
			}
			else if(currentpiece==6){
				 if(shape==1){	
						if((board[p1y][p1x+2]==0 || board[p1y][p1x+2]==1 )&& (board[p2y+1][p2x+1]==0 || board[p2y+1][p2x+1]==1)&& (board[p4y+1][p4x-1]==0 || board[p4y+1][p4x-1]==1)){
							board[p4y+1][p4x-1]=1;
							board[p2y+1][p2x+1]=1;
							board[p1y][p1x+2]=1;
							board[p1y+1][p1x]=0;
							board[p2y+1][p2x]=0;
							board[p4y+1][p4x]=0; 
							p1x=p1x+2;
							p1y=p1y;
							p2y=p2y+1;
							p2x=p2x+1;
							p4y=p4y+1;
							p4x=p4x-1;
							update();
							shape=2;
						}
					  }
				 else if(shape==2){	
					 if((board[p1y][p1x-2]==0 || board[p1y][p1x-2]==1 )&& (board[p2y-1][p2x-1]==0 || board[p2y-1][p2x-1]==1)&& (board[p4y-1][p4x+1]==0 || board[p4y-1][p4x+1]==1)){
							board[p4y-1][p4x+1]=1;
							board[p2y-1][p2x-1]=1;
							board[p1y][p1x-2]=1;
							board[p1y+1][p1x]=0;
							board[p2y+1][p2x]=0;
							board[p4y+1][p4x]=0; 
							p1x=p1x-2;
							p1y=p1y;
							p2y=p2y-1;
							p2x=p2x-1;
							p4y=p4y-1;
							p4x=p4x+1;
							update();
							shape=1;
						}
					  }
				
			}
			else if(currentpiece==7){
				  if(shape==1){	
					if((board[p1y+1][p1x+1]==0 || board[p1y+1][p1x+1]==1 )&& (board[p2y-1][p2x+1]==0 || board[p2y-1][p2x+1]==1)&& (board[p4y+1][p4x-1]==0 || board[p4y+1][p4x-1]==1)){
						board[p4y+1][p4x-1]=1;
						board[p2y-1][p2x+1]=1;
						board[p1y+1][p1x+1]=1;
						board[p1y+1][p1x]=0;
						board[p2y+1][p2x]=0;
						board[p4y+1][p4x]=0; 
						p1x=p1x+1;
						p1y=p1y+1;
						p2y=p2y-1;
						p2x=p2x+1;
						p4y=p4y+1;
						p4x=p4x-1;
						update();
						shape=2;
					}
				  }
				  	else if(shape==2){	
				  		if((board[p1y+1][p1x-1]==0 || board[p1y+1][p1x-1]==1 )&& (board[p2y+1][p2x+1]==0 || board[p2y+1][p2x+1]==1)&& (board[p4y-1][p4x-1]==0 || board[p4y-1][p4x-1]==1)){
							board[p4y-1][p4x-1]=1;
							board[p2y+1][p2x+1]=1;
							board[p1y+1][p1x-1]=1;
							board[p1y+1][p1x]=0;
							board[p2y+1][p2x]=0;
							board[p4y+1][p4x]=0; 
							p1x=p1x-1;
							p1y=p1y+1;
							p2y=p2y+1;
							p2x=p2x+1;
							p4y=p4y-1;
							p4x=p4x-1;
							update();
							shape=3;
						}
					 }
					else if(shape==3){	
						if((board[p1y-1][p1x-1]==0 || board[p1y-1][p1x-1]==1 )&& (board[p2y+1][p2x-1]==0 || board[p2y+1][p2x-1]==1)&& (board[p4y-1][p4x+1]==0 || board[p4y-1][p4x+1]==1)){
							board[p4y-1][p4x+1]=1;
							board[p2y+1][p2x-1]=1;
							board[p1y-1][p1x-1]=1;
							board[p1y+1][p1x]=0;
							board[p2y+1][p2x]=0;
							board[p4y+1][p4x]=0; 
							p1x=p1x-1;
							p1y=p1y-1;
							p2y=p2y+1;
							p2x=p2x-1;
							p4y=p4y-1;
							p4x=p4x+1;
							update();
							shape=4;
						}
					 }
					else if(shape==4){	
						if((board[p1y-1][p1x+1]==0 || board[p1y-1][p1x+1]==1 )&& (board[p2y-1][p2x-1]==0 || board[p2y-1][p2x-1]==1)&& (board[p4y+1][p4x+1]==0 || board[p4y+1][p4x+1]==1)){
							board[p4y+1][p4x+1]=1;
							board[p2y-1][p2x-1]=1;
							board[p1y-1][p1x+1]=1;
							board[p1y+1][p1x]=0;
							board[p2y+1][p2x]=0;
							board[p4y+1][p4x]=0; 
							p1x=p1x+1;
							p1y=p1y-1;
							p2y=p2y-1;
							p2x=p2x-1;
							p4y=p4y+1;
							p4x=p4x+1;
							update();
							shape=1;
						}
					 }
				}
		}
	    
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	
		
	}

	public void drop(int a){
		    board[p1y+1][p1x]=a;
		    board[p2y+1][p2x]=a;
		    board[p3y+1][p3x]=a;
		    board[p4y+1][p4x]=a;
	}
	public void actionPerformed(ActionEvent arg0) {
		if((board[p1y+2][p1x]==1 || board[p1y+2][p1x]==0) && (board[p2y+2][p2x]==0 || board[p2y+2][p2x]==1) && (board[p3y+2][p3x]==0 || board[p3y+2][p3x]==1) && (board[p4y+2][p4x]==0 || board[p4y+2][p4x]==1) && game==true){
		p1y++;
		p2y++;
		p3y++;
		p4y++;
		update();
		print();
		}
		if((board[p1y+2][p1x]!=1 && board[p1y+2][p1x]!=0) || (board[p2y+2][p2x]!=0 && board[p2y+2][p2x]!=1) || (board[p3y+2][p3x]!=0 && board[p3y+2][p3x]!=1) || (board[p4y+2][p4x]!=0 && board[p4y+2][p4x]!=1)){
		/*	    board[p1y+1][p1x]=3;
			    board[p2y+1][p2x]=3;
			    board[p3y+1][p3x]=3;
			    board[p4y+1][p4x]=3;  */
			switch(currentpiece){
			case 1:
				drop(11);
				break;
			case 2:
				drop(12);
				break;
			case 3:
				drop(13);
				break;
			case 4:
				drop(14);
				break;
			case 5:
				drop(15);
				break;
			case 6:
				drop(16);
				break;
			case 7:
				drop(17);
				break;
			default:
				drop(18);
				break;
			}
			random();	
		}
		
	}
	public static void random(){
		if(game==true){
		int number=(int)(Math.random()*100);
		if(number<7)longpiece();
		else if(number>=7 && number<15)square();
		else if(number>=15 && number<32)lright();
		else if(number>=32 && number<49)lleft();
		else if(number>=49 && number<66)zigzagright();
		else if(number>=66 && number<83)zigzagleft();
		else if(number>=83 && number<=100)tpiece();
		shape=1;
		score=score+1;
		if((board[p1y+1][p1x]!=1 && board[p1y+1][p1x]!=0) || (board[p2y+1][p2x]!=1 && board[p2y+1][p2x]!=0) || (board[p3y+1][p3x]!=1 && board[p3y+1][p3x]!=0) || (board[p4y+1][p4x]!=1 && board[p4y+1][p4x]!=0)){
			game=false;
			j.repaint();
		}
		}
		
			
	}
	public static void longpiece(){
		p1x=6;
		p2x=6;
		p3x=6;
		p4x=6;
		p1y=0;
		p2y=1;
		p3y=2;
		p4y=3;
		currentpiece=1;
	}
	public static void lright(){
		p1x=5;
		p2x=6;
		p3x=7;
		p4x=7;
		p1y=1;
		p2y=1;
		p3y=1;
		p4y=0;
		currentpiece=2;
	}
	public static void lleft(){
		p1x=5;
		p2x=5;
		p3x=6;
		p4x=7;
		p1y=0;
		p2y=1;
		p3y=1;
		p4y=1;
		currentpiece=3;
	}
	public static void square(){
		p1x=5;
		p2x=6;
		p3x=5;
		p4x=6;
		p1y=0;
		p2y=0;
		p3y=1;
		p4y=1;
		currentpiece=4;
	}
	public static void zigzagright(){
		p1x=5;
		p2x=6;
		p3x=6;
		p4x=7;
		p1y=1;
		p2y=1;
		p3y=0;
		p4y=0;
		currentpiece=5;
	}
	public static void zigzagleft(){
		p1x=5;
		p2x=6;
		p3x=6;
		p4x=7;
		p1y=0;
		p2y=0;
		p3y=1;
		p4y=1;
		currentpiece=6;
	}
	public static void tpiece(){
		p1x=6;
		p2x=5;
		p3x=6;
		p4x=7;
		p1y=0;
		p2y=1;
		p3y=1;
		p4y=1;
		currentpiece=7;
	}
	public static void lineclear(){
		for(int a=0;a<board.length;a++){
			int counter=0;
			for(int b=0;b<board[0].length;b++){
				if(board[a][b]==11 || board[a][b]==12 || board[a][b]==13 || board[a][b]==14 || board[a][b]==15 || board[a][b]==16 || board[a][b]==17 || board[a][b]==18)counter++;
			}
			if(counter==10){
				score=score+10;
				int line=a;
				int newboard[][]=new int[a][12];
					for(int c=0;c<newboard.length;c++){
						for(int d=0;d<newboard[0].length;d++){
							newboard[c][d]=board[c][d];
						}
					}
					for(int c=1;c<newboard.length+1;c++){
						for(int d=0;d<newboard[0].length;d++){
							board[c][d]=newboard[c-1][d];
						}
					}
			}
		}
	}
	public static void gamecheck(){
		for(int a=0;a<board[2].length;a++){
			if(board[2][a]==3)game=false;
		}
		j.repaint();
	}
	public static void print(){
		for(int a=0;a<board.length;a++){
			for(int b=0;b<board[0].length;b++){
				System.out.print(board[a][b]);
			}
			System.out.println();
		}
	}
	public static void restart(){
		 
		 score=0;
		 int newboard[][]={	{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,2},
			{2,2,2,2,2,2,2,2,2,2,2,2}};	 
		 for(int a=0;a<board.length;a++){
			 for(int b=0;b<board[0].length;b++){
				 board[a][b]=newboard[a][b];
			 }
		 }
	}
}
