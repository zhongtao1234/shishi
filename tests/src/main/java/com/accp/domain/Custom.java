package com.accp.domain;

import java.util.List;

public class Custom {
    private Integer id;

    private String name;

    private String link;

    private String creatdate;

    private String phone;

    private String address;

    private String principal;

    private String numberid;
    
    public Customaddress getDetail() {
		return detail;
	}

	public void setDetail(Customaddress detail) {
		this.detail = detail;
	}

	private Customaddress detail;
private List<Customaddress> details;
    
    public List<Customaddress> getDetails() {
		return details;
	}

	public void setDetails(List<Customaddress> details) {
		this.details = details;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(String creatdate) {
        this.creatdate = creatdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getNumberid() {
        return numberid;
    }

    public void setNumberid(String numberid) {
        this.numberid = numberid;
    }
}