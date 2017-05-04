package elimGame2;

public enum BlockEnum {	
	RED(1,"ºì"), GREEN(2,"ÂÌ"), WHITE(3,"°×"), YELLOW(4,"»Æ") ,PURPLE(5,"×Ï"),BLUE(6,"À¶"),ELIM(0,"²æ²æ");
	
	public int _value;
	public final String colour;
	private BlockEnum(int value,String s){
		this._value=value;
		colour=s;
	}
	
	public int value(){
		return this._value;
	}
	public String colour(){
		return colour;
	}
	
	
	
}

