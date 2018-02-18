package beanpack;

public class logbean{
	private String	username;
	private String pwd;
	private String kind;
	
	/* (non-Javadoc)
	 * @see beanpack.logb#setUsername(java.lang.String)
	 */
	public void setUsername(String username){
		this.username=username;
	}
	/* (non-Javadoc)
	 * @see beanpack.logb#getUsername()
	 */
	public String getUsername(){
		return username;
	}
	
	/* (non-Javadoc)
	 * @see beanpack.logb#setPwd(java.lang.String)
	 */
	public void setPwd(String pwd){
		this.pwd=pwd;
	}

	/* (non-Javadoc)
	 * @see beanpack.logb#getPwd()
	 */
	public String getPwd(){
		return pwd;
	}
	
	/* (non-Javadoc)
	 * @see beanpack.logb#setOld(java.lang.String)
	 */
	public void setKind(String kind){
		this.kind=kind;
	}
	
	/* (non-Javadoc)
	 * @see beanpack.logb#getOld()
	 */
	public String getKind(){
		return kind;
	}
}
