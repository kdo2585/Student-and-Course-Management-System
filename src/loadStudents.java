/* Kevin Do
 * 
 * This program pre-loads the list of students for the table in the studentInformation program
 * 
 */

import javax.swing.table.DefaultTableModel;

public class loadStudents {
	
	public static void authenticate(DefaultTableModel model) {
		model.addRow(new Object[] { "John", "C","Elizabeth","09/21/1990","88542136","Computer Science","3.38" });
		model.addRow(new Object[] { "Sandy", "A","Terry","05/15/1992","3451873","Religion","2.63" });
		model.addRow(new Object[] { "Penny", "F","Dixon","03/01/1994","9622762","Biology","3.56" });
		model.addRow(new Object[] { "Leo", "E","Wood","03/31/1989","9935354","Computer Science","2.97" });
		model.addRow(new Object[] { "Anna", "J","Wilson","01/21/1994","1566904","Nursing","3.98" });
		model.addRow(new Object[] { "Lauren", "N","Stephens","11/23/1995","2688423","Business","2.03" });
		model.addRow(new Object[] { "Lance", "K","Silva","12/11/1987","7489794","Biology","3.72" });
		model.addRow(new Object[] { "Rafael", "M","Russell","07/27/1990","4967899","Philosophy","3.07" });
		model.addRow(new Object[] { "Matthew", "L","Ann","03/19/1992","8406764","Chemistry","3.49" });
		model.addRow(new Object[] { "Michael", "P","Penny","09/06/1993","3470694","Music","2.44" });
	}

}
