/**
 *
 */
package crptest;

public class CrapsBet {

  private int[][] betspectrum;

  private int investment; // How much is needed to make this bet?
  private boolean isflexible;
  private String name;
  private double differential;

  private Workbook workbook;

  public CrapsBet(String name, Workbook workbook) {
    betspectrum[][] = new int[6][6];
    this.name = name;
    this.workbook = workbook;
    try {
      workbook.getSheet(name);
      betspectrum[0][0] = Integer.parseInt(sheet.getCell(1, 1).getContents());
      betspectrum[0][1] = Integer.parseInt(sheet.getCell(1, 2).getContents());
      betspectrum[0][2] = Integer.parseInt(sheet.getCell(1, 3).getContents());
      betspectrum[0][3] = Integer.parseInt(sheet.getCell(1, 4).getContents());
      betspectrum[0][4] = Integer.parseInt(sheet.getCell(1, 5).getContents());
      betspectrum[0][5] = Integer.parseInt(sheet.getCell(1, 6).getContents());

      betspectrum[1][0] = Integer.parseInt(sheet.getCell(2, 1).getContents());
      betspectrum[1][1] = Integer.parseInt(sheet.getCell(2, 2).getContents());
      betspectrum[1][2] = Integer.parseInt(sheet.getCell(2, 3).getContents());
      betspectrum[1][3] = Integer.parseInt(sheet.getCell(2, 4).getContents());
      betspectrum[1][4] = Integer.parseInt(sheet.getCell(2, 5).getContents());
      betspectrum[1][5] = Integer.parseInt(sheet.getCell(2, 6).getContents());

      betspectrum[2][0] = Integer.parseInt(sheet.getCell(3, 1).getContents());
      betspectrum[2][1] = Integer.parseInt(sheet.getCell(3, 2).getContents());
      betspectrum[2][2] = Integer.parseInt(sheet.getCell(3, 3).getContents());
      betspectrum[2][3] = Integer.parseInt(sheet.getCell(3, 4).getContents());
      betspectrum[2][4] = Integer.parseInt(sheet.getCell(3, 5).getContents());
      betspectrum[2][5] = Integer.parseInt(sheet.getCell(3, 6).getContents());

      betspectrum[3][0] = Integer.parseInt(sheet.getCell(4, 1).getContents());
      betspectrum[3][1] = Integer.parseInt(sheet.getCell(4, 2).getContents());
      betspectrum[3][2] = Integer.parseInt(sheet.getCell(4, 3).getContents());
      betspectrum[3][3] = Integer.parseInt(sheet.getCell(4, 4).getContents());
      betspectrum[3][4] = Integer.parseInt(sheet.getCell(4, 5).getContents());
      betspectrum[3][5] = Integer.parseInt(sheet.getCell(4, 6).getContents());

      betspectrum[4][0] = Integer.parseInt(sheet.getCell(5, 1).getContents());
      betspectrum[4][1] = Integer.parseInt(sheet.getCell(5, 2).getContents());
      betspectrum[4][2] = Integer.parseInt(sheet.getCell(5, 3).getContents());
      betspectrum[4][3] = Integer.parseInt(sheet.getCell(5, 4).getContents());
      betspectrum[4][4] = Integer.parseInt(sheet.getCell(5, 5).getContents());
      betspectrum[4][5] = Integer.parseInt(sheet.getCell(5, 6).getContents());

      betspectrum[5][0] = Integer.parseInt(sheet.getCell(6, 1).getContents());
      betspectrum[5][1] = Integer.parseInt(sheet.getCell(6, 2).getContents());
      betspectrum[5][2] = Integer.parseInt(sheet.getCell(6, 3).getContents());
      betspectrum[5][3] = Integer.parseInt(sheet.getCell(6, 4).getContents());
      betspectrum[5][4] = Integer.parseInt(sheet.getCell(6, 5).getContents());
      betspectrum[5][5] = Integer.parseInt(sheet.getCell(6, 6).getContents());
    } catch (Exception e) {
      System.err.println("Error when retrieving sheet " + name + " from Excel document.");
			System.exit(-13);
    }
  }

  public int[][] getSpectrum() {
    return betspectrum;
  }

  public int getInvestment() {
    return investment;
  }

  public double getDifferential() {
    return differential;
  }
}
