package com.csm.Utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

/**
 * @Project : BroadbandConnection
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/09/2022 - 10:33 AM
 */
public class AgeCalculator {

	public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			return 0;
		}
	}
}
