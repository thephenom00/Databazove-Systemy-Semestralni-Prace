package entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "public", catalog = "leductha")
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id")
    private int categoryId;
    @Basic
    @Column(name = "category_name")
    private String categoryName;
    @OneToMany(mappedBy = "categoryByCategoryName")
    private Collection<ProductEntity> productsByCategoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return categoryId == that.categoryId && Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName);
    }

    public Collection<ProductEntity> getProductsByCategoryId() {
        return productsByCategoryId;
    }

    public void setProductsByCategoryId(Collection<ProductEntity> productsByCategoryId) {
        this.productsByCategoryId = productsByCategoryId;
    }
}
