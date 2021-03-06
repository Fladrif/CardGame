import javax.swing.*;

public class CardImages{
	ImageIcon s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, sj, sq, sk;
	ImageIcon c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, cj, cq, ck;
	ImageIcon d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, dj, dq, dk;
	ImageIcon h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, hj, hq, hk;
	public CardImages(){
		s1 = new ImageIcon("CardImages/s1.png");
		s2 = new ImageIcon("CardImages/s2.png");
		s3 = new ImageIcon("CardImages/s3.png");
		s4 = new ImageIcon("CardImages/s4.png");
		s5 = new ImageIcon("CardImages/s5.png");
		s6 = new ImageIcon("CardImages/s6.png");
		s7 = new ImageIcon("CardImages/s7.png");
		s8 = new ImageIcon("CardImages/s8.png");
		s9 = new ImageIcon("CardImages/s9.png");
		s10 = new ImageIcon("CardImages/s10.png");
		sj = new ImageIcon("CardImages/sj.png");
		sq = new ImageIcon("CardImages/sq.png");
		sk = new ImageIcon("CardImages/sk.png");
		c1 = new ImageIcon("CardImages/c1.png");
		c2 = new ImageIcon("CardImages/c2.png");
		c3 = new ImageIcon("CardImages/c3.png");
		c4 = new ImageIcon("CardImages/c4.png");
		c5 = new ImageIcon("CardImages/c5.png");
		c6 = new ImageIcon("CardImages/c6.png");
		c7 = new ImageIcon("CardImages/c7.png");
		c8 = new ImageIcon("CardImages/c8.png");
		c9 = new ImageIcon("CardImages/c9.png");
		c10 = new ImageIcon("CardImages/c10.png");
		cj = new ImageIcon("CardImages/cj.png");
		cq = new ImageIcon("CardImages/cq.png");
		ck = new ImageIcon("CardImages/ck.png");
		d1 = new ImageIcon("CardImages/d1.png");
		d2 = new ImageIcon("CardImages/d2.png");
		d3 = new ImageIcon("CardImages/d3.png");
		d4 = new ImageIcon("CardImages/d4.png");
		d5 = new ImageIcon("CardImages/d5.png");
		d6 = new ImageIcon("CardImages/d6.png");
		d7 = new ImageIcon("CardImages/d7.png");
		d8 = new ImageIcon("CardImages/d8.png");
		d9 = new ImageIcon("CardImages/d9.png");
		d10 = new ImageIcon("CardImages/d10.png");
		dj = new ImageIcon("CardImages/dj.png");
		dq = new ImageIcon("CardImages/dq.png");
		dk = new ImageIcon("CardImages/dk.png");
		h1 = new ImageIcon("CardImages/h1.png");
		h2 = new ImageIcon("CardImages/h2.png");
		h3 = new ImageIcon("CardImages/h3.png");
		h4 = new ImageIcon("CardImages/h4.png");
		h5 = new ImageIcon("CardImages/h5.png");
		h6 = new ImageIcon("CardImages/h6.png");
		h7 = new ImageIcon("CardImages/h7.png");
		h8 = new ImageIcon("CardImages/h8.png");
		h9 = new ImageIcon("CardImages/h9.png");
		h10 = new ImageIcon("CardImages/h10.png");
		hj = new ImageIcon("CardImages/hj.png");
		hq = new ImageIcon("CardImages/hq.png");
		hk = new ImageIcon("CardImages/hk.png");
	}
	public ImageIcon getIconVar(String cardVal){
		switch(cardVal){
			case "sA": return s1;
			case "s2": return s2;
			case "s3": return s3;
			case "s4": return s4;
			case "s5": return s5;
			case "s6": return s6;
			case "s7": return s7;
			case "s8": return s8;
			case "s9": return s9;
			case "s10": return s10;
			case "sJ": return sj;
			case "sQ": return sq;
			case "sK": return sk;
			case "cA": return c1;
			case "c2": return c2;
			case "c3": return c3;
			case "c4": return c4;
			case "c5": return c5;
			case "c6": return c6;
			case "c7": return c7;
			case "c8": return c8;
			case "c9": return c9;
			case "c10": return c10;
			case "cJ": return cj;
			case "cQ": return cq;
			case "cK": return ck;
			case "dA": return d1;
			case "d2": return d2;
			case "d3": return d3;
			case "d4": return d4;
			case "d5": return d5;
			case "d6": return d6;
			case "d7": return d7;
			case "d8": return d8;
			case "d9": return d9;
			case "d10": return d10;
			case "dJ": return dj;
			case "dQ": return dq;
			case "dK": return dk;
			case "hA": return h1;
			case "h2": return h2;
			case "h3": return h3;
			case "h4": return h4;
			case "h5": return h5;
			case "h6": return h6;
			case "h7": return h7;
			case "h8": return h8;
			case "h9": return h9;
			case "h10": return h10;
			case "hJ": return hj;
			case "hQ": return hq;
			case "hK": return hk;
		}
		return null;
	}
}
