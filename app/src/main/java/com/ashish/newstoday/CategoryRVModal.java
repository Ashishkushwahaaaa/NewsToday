package com.ashish.newstoday;

public class CategoryRVModal {
    private String category;
    private String categoryImageUrl;

    CategoryRVModal(String category, String categoryImageUrl){
        this.category = category;
        this.categoryImageUrl = categoryImageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }
}
