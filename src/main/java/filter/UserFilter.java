package filter;


import java.util.regex.Pattern;



public class UserFilter {
	private static final Pattern PEATTERN = Pattern.compile("[0-9]+");
	private String findTopic;
	private String searchName = "";
	private String searchAutor = "";
	
	private String maxPrice;
	
	private String minPrice;
	
	private Integer maxPr;
	
	private Integer minPr;
	
	private String maxYear = "";
	
	private String minYear = "";
	
	private Integer maxY;
	
	private Integer minY;
	
	private String maxPages = "";
	
	private String minPages = "";
	
	private Integer maxPa;
	
	private Integer minPa;
	
	private String language = "";
	private String addition = "";
	
	
	
	
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getSearchAutor() {
		return searchAutor;
	}
	public void setSearchAutor(String searchAutor) {
		this.searchAutor = searchAutor;
	}
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		if(PEATTERN.matcher(maxPrice).matches())maxPr=Integer.valueOf(maxPrice);
		this.maxPrice = maxPrice;
	}
	public String getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(String minPrice) {
		if(PEATTERN.matcher(minPrice).matches())minPr=Integer.valueOf(minPrice);
		this.minPrice = minPrice;
	}
	public Integer getMaxPr() {
		return maxPr;
	}
	public void setMaxPr(Integer maxPr) {
		this.maxPr = maxPr;
	}
	public Integer getMinPr() {
		return minPr;
	}
	public void setMinPr(Integer minPr) {
		this.minPr = minPr;
	}
	public String getMaxYear() {
		return maxYear;
	}
	public void setMaxYear(String maxYear) {
		if(PEATTERN.matcher(maxYear).matches())maxY=Integer.valueOf(maxYear);
		this.maxYear = maxYear;
	}
	public String getMinYear() {
		return minYear;
	}
	public void setMinYear(String minYear) {
		if(PEATTERN.matcher(minYear).matches())minY=Integer.valueOf(minYear);
		this.minYear = minYear;
	}
	public Integer getMaxY() {
		return maxY;
	}
	public void setMaxY(Integer maxY) {
		this.maxY = maxY;
	}
	public Integer getMinY() {
		return minY;
	}
	public void setMinY(Integer minY) {
		this.minY = minY;
	}
	public String getMaxPages() {
		return maxPages;
	}
	public void setMaxPages(String maxPages) {
		if(PEATTERN.matcher(maxPages).matches())maxPa=Integer.valueOf(maxPages);
		this.maxPages = maxPages;
	}
	public String getMinPages() {
		return minPages;
	}
	public void setMinPages(String minPages) {
		if(PEATTERN.matcher(minPages).matches())minPa=Integer.valueOf(minPages);
		this.minPages = minPages;
	}
	public Integer getMaxPa() {
		return maxPa;
	}
	public void setMaxPa(Integer maxPa) {
		this.maxPa = maxPa;
	}
	public Integer getMinPa() {
		return minPa;
	}
	public void setMinPa(Integer minPa) {
		this.minPa = minPa;
	}
	
	
	
	


	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getAddition() {
		return addition;
	}
	public void setAddition(String addition) {
		this.addition = addition;
	}
	public UserFilter() {
		super();
	}


	public String getFindTopic() {
		return findTopic;
	}


	public void setFindTopic(String findTopic) {
		this.findTopic = findTopic;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((findTopic == null) ? 0 : findTopic.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserFilter other = (UserFilter) obj;
		if (findTopic == null) {
			if (other.findTopic != null)
				return false;
		} else if (!findTopic.equals(other.findTopic))
			return false;
		return true;
	}

	
	
	

	
	

	
	

}
