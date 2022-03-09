package ch16;

public class SwitchCaseUpTest {

	public static void main(String[] args) {
		int month = 3;
		
		int day = switch (month) {
	    	case 1, 3, 5, 7, 8, 10,12 -> {
	    		System.out.println("�� ���� 31���Դϴ�."); 
	    		yield 31;
	    	}
	    	case 4,6,9,11 -> {
	    		System.out.println("�� ���� 30���Դϴ�."); 
	    		yield 30;
	    	}
	    	case 2 ->{
	    		System.out.println("�� ���� 28���Դϴ�.");
	    		yield 28;
	    	}
	    	default->{
	    		System.out.println("�������� �ʴ� �� �Դϴ�."); 
	    		yield 0;
	    	}
		};
		System.out.println(month + "���� " + day + "���Դϴ�.");

	}

}
