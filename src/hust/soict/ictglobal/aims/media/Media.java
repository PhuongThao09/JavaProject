package hust.soict.ictglobal.aims.media;

public abstract class Media {
	
	
	private String id;
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}




	private String title;
	private String category;
	private float cost;
	

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
	


	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}


	public Media(String title) {
		super();
		this.title = title;
	}


	public Media() {
		// TODO Auto-generated constructor stub
	}
	public boolean equals(Object obj) {
		//if(anObject instanceof e)
		if(obj==null) {
			throw (new NullPointerException());
	
		}
		if (obj instanceof Media) {    				// chiu thoi khong viet getClass duoc
		if( getClass() !=obj.getClass() )
			throw(new ClassCastException());
		Media md = (Media) obj;
		if((this.getTitle().compareTo(md.getTitle())==0) && this.getCost()==md.getCost())
			return true;
		return false;
		}else
			throw (new ClassCastException());
	}
	public int compareTo(Object obj) {
		if(obj==null) {
			throw (new NullPointerException());
		
		}
		if (obj instanceof Media) {
			if( getClass() !=obj.getClass() )
				throw(new ClassCastException());
			Media md = (Media) obj;
		if((this.getTitle().compareTo(md.getTitle())==0) && this.getCost()==md.getCost())
			return 0;
		else
			return -5;
	}else
		throw (new ClassCastException());
		
	}


	public int compareTo(Media disc) {
		// TODO Auto-generated method stub
		return 0;
	}
}
