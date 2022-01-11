package questions;

import java.util.ArrayList;

/**
 * TRUE FALSE CLASS.
 */
public class TrueFalse implements Question {
  private final String question;

  private String correctAnswer;

  /**
   * constructor for initializing variables.
   */

  public TrueFalse(String question, String... options) {
    this.question = question;
    ArrayList<String> options1 = new ArrayList<String>();
    for (int i = 0; i < options.length - 1; i++) {
      options1.add(options[i]);

    }
    this.correctAnswer = options[options.length - 1];

  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof TrueFalse) {
      return this.question.compareTo(o.getText());

    } else if (o instanceof MultipleChoice) {
      return -1;

    } else if (o instanceof MultipleSelect) {
      return -1;
    } else {
      return -1;
    }
  }

  @Override
  public String answer(String answer) {
    if (this.correctAnswer == answer) {
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
