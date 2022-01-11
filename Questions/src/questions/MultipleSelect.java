package questions;

import java.util.ArrayList;

/**
 * multiple select class.
 */

public class MultipleSelect implements Question {
  private final String question;
  private final String correctAnswer;
  private final ArrayList<String> options;

  /**
   * constructor for initializing variables.
   */
  public MultipleSelect(String question, String correctAnswer, String... options) {
    this.question = question;
    this.correctAnswer = correctAnswer;
    this.options = new ArrayList<String>();
    for (int i = 0; i < options.length; i++) {
      this.options.add(options[i]);
    }
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof TrueFalse) {
      return 1;

    } else if (o instanceof MultipleChoice) {
      return 1;

    } else if (o instanceof MultipleSelect) {
      return this.question.compareTo(o.getText());
    } else {
      return -1;
    }
  }

  @Override
  public String answer(String answer) {
    int flag = 0;
    String[] ans = answer.split(" ");
    if (ans.length > this.options.size()) {
      return INCORRECT;
    }
    if (ans.length == 0) {
      return INCORRECT;
    }
    String[] corAns = this.correctAnswer.split(" ");
    if (corAns.length != ans.length) {
      return INCORRECT;
    }
    for (int i = 0; i < ans.length; i++) {
      if (!this.correctAnswer.contains(ans[i])) {
        flag = 1;
      }
    }
    if (flag == 1) {
      return INCORRECT;
    } else {
      return CORRECT;
    }

  }

  @Override
  public String getText() {
    return this.question;
  }

}
