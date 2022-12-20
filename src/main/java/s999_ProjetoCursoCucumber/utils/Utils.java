package s999_ProjetoCursoCucumber.utils;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class Utils {

	public static String formataData(Date data) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formato.format(data);
		return dataFormatada;
	}

	public static java.sql.Date converterStringDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return new java.sql.Date(sdf.parse(date).getTime());
	}

	// M�todo para formatar um valor
	public static String formatarMoeda(double vlr) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,##0.00");
		return df.format(vlr);
	}

	public static String removerAcentos(String valorAcentuado) {
		return Normalizer.normalize(valorAcentuado, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public static long subtrairDatasEmSegundos(LocalDateTime dataInicial, LocalDateTime dataFinal) {

		Duration diferenca = Duration.between(dataInicial, dataFinal);
		// LocalTime localTimeDiferenca = LocalTime.ofNanoOfDay(diferenca.getSeconds());
		return diferenca.getSeconds();
	}
}
