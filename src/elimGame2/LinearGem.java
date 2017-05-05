package elimGame2;
//4.	同一行（同一列）四块相同颜色宝石消除后在置换位置产生一块相同颜色的条形特效宝石。如果是同一行（同一列）四块宝石消除后产生的条形特效宝石在下一次被消除时可以发动特效消掉所处列（行）整列（行）的宝石；
//7.	注意：当规则4情况与规则5情况同时出现时（六块颜色相同宝石），消除后在置换位置产生一块相同颜色的十字特效宝石。该十字特效宝石被消除时会消除所处位置整行和整列所有宝石。
public class LinearGem extends CommonGem {

	



	public LinearGem(BlockEnum c, int i, int j) {
		super(c, i, j);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public String getColor(){
		return this.color.colour+"长";
	}
}
