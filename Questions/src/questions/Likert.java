package questions;

import java.util.Objects;

/**
 * Likert Class.
 */
public class Likert implements Question {
  private final String question;

  public Likert(String question) {
    this.question = question;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof TrueFalse) {
      return 1;

    } else if (o instanceof MultipleChoice) {
      return 1;

    } else if (o instanceof MultipleSelect) {
      return 1;
    } else {
      return this.question.compareTo(o.getText());
    }

  }

  @Override
  public int hashCode() {
    return Objects.hash(question);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Likert other = (Likert) obj;
    return Objects.equals(question, other.question);
  }

  @Override
  public String answer(String answer) {
    if (answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4")
        || answer.equals("5")) {
      return CORRECT;
    } else {
      return INCORRECT;
    }
  }

  @Override
  public String getText() {

    return this.question;
  }

}
