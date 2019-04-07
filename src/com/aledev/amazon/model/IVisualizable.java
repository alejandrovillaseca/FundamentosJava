package com.aledev.amazon.model;

import java.util.Date;

public interface IVisualizable {
	/**
	 * Éste método captura el tiempo exacto de inicio de visualización
	 * @param dateI Es un objeto {@code Date} con el tiempo exacto de inicio.
	 * @return Devuelve la fecha y hora capturada
	 */
	Date startToSee(Date dateI);
	/**
	 * Éste método captura el tiempo exacto de inicio de visualización y final.
	 * @param dateI Tipo Date {@code Date}
	 * @param dateF Fecha final {@code Final Code}
	 */
	void stopToSee(Date dateI, Date dateF);
	
}

