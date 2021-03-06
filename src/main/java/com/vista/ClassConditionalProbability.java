package com.vista;

/**
 * <b>类</b>条件概率计算
 * 
 * <h3>类条件概率</h3> P(x<sub>j</sub>|c<sub>j</sub>)=( N(X=x<sub>i</sub>, C=c<sub>j
 * </sub>)+1 ) <b>/</b> ( N(C=c<sub>j</sub>)+M+V ) <br>
 * 其中，N(X=x<sub>i</sub>, C=c<sub>j</sub>）表示类别c<sub>j</sub>中包含属性x<sub>
 * i</sub>的训练文本数量；N(C=c<sub>j</sub>)表示类别c<sub>j</sub>中的训练文本数量；M值用于避免
 * N(X=x<sub>i</sub>, C=c<sub>j</sub>）过小所引发的问题；V表示类别的总数。
 * 
 * <h3>条件概率</h3> <b>定义</b> 设A, B是两个事件，且P(A)>0 称<br>
 * <tt>P(B∣A)=P(AB)/P(A)</tt><br>
 * 为在条件A下发生的条件事件B发生的条件概率。
 */

public class ClassConditionalProbability {
  private static TrainingDataManager tdm = new TrainingDataManager();
  private static final float M = 0F;

  /**
   * 计算类条件概率
   * 
   * @param x
   *          给定的文本属性
   * @param c
   *          给定的分类
   * @return 给定条件下的类条件概率
   */
  public static float calculatePxc(String term, String c) {
    float cp = 0F;
    float nxc = tdm.getCountContainKeyOfClassification(c, term);
    float nc = tdm.getTrainingFileCountOfClassification(c);
    float v = tdm.getTraningClassifications().length;
    cp = (nxc + 1) / (nc + M + v);

    String info = String.format(
        "calculating conditional p nxc:%f nc:%f v:%f cp:%f term:%s", nxc, nc,
        v, cp, term);

    System.out.println(info);

    return cp;
  }
}
