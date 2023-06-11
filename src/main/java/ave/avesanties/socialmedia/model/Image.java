package ave.avesanties.socialmedia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "images")
public class Image {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "path")
  private String path;

  public Image() {

  }

  public Image(String path) {
    this.path = path;
  }

  public Long getId() {
    return id;
  }

  public String getImage() {
    return path;
  }

  public void setImage(String path) {
    this.path = path;
  }
}
