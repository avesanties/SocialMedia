package ave.avesanties.socialmedia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Post {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "header", nullable = false)
  private String header;

  //TODO: check datatype and length in postgresql
  @NotNull
  @Size(min = 1, max = 4000)
  @Column(name = "post_text", nullable = false)
  private String text;

  @NotNull
  @OneToMany(mappedBy = "post_id", fetch = FetchType.EAGER)
  private Set<Image> images = new HashSet<>();

  @NotNull
  @PastOrPresent
  @Column(name = "timestamp", nullable = false)
  private LocalDateTime timestamp;

  public Post() {

  }

  public Post(@NotNull String header, @NotNull String text, @NotNull LocalDateTime timestamp) {
    this.header = header;
    this.text = text;
    this.timestamp = timestamp;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Long getId() {
    return id;
  }

  public Set<Image> getImages() {
    return Collections.unmodifiableSet(images);
  }

  public void addImage(@NotNull Image image){
    images.add(image);
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "Post{" +
        "id=" + id +
        ", header='" + header + '\'' +
        ", timestamp=" + timestamp +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Post post = (Post) o;
    return Objects.equals(id, post.id) && Objects.equals(header, post.header)
        && Objects.equals(text, post.text) && Objects.equals(images, post.images)
        && Objects.equals(timestamp, post.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, header, text, images, timestamp);
  }
}
