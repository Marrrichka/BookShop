package filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BookFilter {
	private static final Pattern PEATTERN = Pattern.compile("[0-9]+");
	
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
	
	List<Integer> baddIds = new ArrayList<>();
	List<Integer> bcIds = new ArrayList<>();
	List<Integer> blIds= new ArrayList<>();
	List<Integer> bpIds = new ArrayList<>();
	List<Integer> btpcIds = new ArrayList<>();
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
	
	
	public List<Integer> getBaddIds() {
		return baddIds;
	}
	public void setBaddIds(List<Integer> baddIds) {
		this.baddIds = baddIds;
	}
	public List<Integer> getBcIds() {
		return bcIds;
	}
	public void setBcIds(List<Integer> bcIds) {
		this.bcIds = bcIds;
	}
	public List<Integer> getBlIds() {
		return blIds;
	}
	public void setBlIds(List<Integer> blIds) {
		this.blIds = blIds;
	}
	public List<Integer> getBpIds() {
		return bpIds;
	}
	public void setBpIds(List<Integer> bpIds) {
		this.bpIds = bpIds;
	}
	public List<Integer> getBtpcIds() {
		return btpcIds;
	}
	public void setBtpcIds(List<Integer> btpcIds) {
		this.btpcIds = btpcIds;
	}
	public static Pattern getPeattern() {
		return PEATTERN;
	}

	
}
