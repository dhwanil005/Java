package questions;

import java.util.ArrayList;

/**
 * Multiple Choice Class.
 */

public class MultipleChoice implements Question {
  private final String question;
  private String correctAnswer;
  

  /**
   * constructor for initializing variables.
   */

  public MultipleChoice(String question, String correctAnswer, String... options) {
    this.question = question;
    this.correctAnswer = correctAnswer;
    ArrayList<String> options1 = new ArrayList<String>();
    for (int i = 0; i < options.length; i++) {
      options1.add(options[i]);
    }

  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof TrueFalse) {
      return 1;

    } else if (o instanceof MultipleChoice) {
      return this.question.compareTo(o.getText());

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
