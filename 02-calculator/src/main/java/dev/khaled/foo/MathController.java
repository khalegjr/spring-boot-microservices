package dev.khaled.foo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.khaled.exception.MathOperationException;

@RestController
public class MathController {
	
	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]");
	}
	
	private Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		
		String number = strNumber.replaceAll(",", ".");
		
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationException("Please, set a numeric value!");
		}
		
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		
		return sum;
	}

	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationException("Please, set a numeric value!");
		}
		
		Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
		
		return sub;
	}
	
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mult(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationException("Please, set a numeric value!");
		}
		
		Double mult = convertToDouble(numberOne) * convertToDouble(numberTwo);
		
		return mult;
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationException("Please, set a numeric value!");
		}
		
		Double div = convertToDouble(numberOne) / convertToDouble(numberTwo);
		
		return div;
	}
	
	@RequestMapping(value = "/mea/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mea(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationException("Please, set a numeric value!");
		}
		
		Double mea = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
		
		return mea;
	}
	
	@RequestMapping(value = "/sqr/{number}", method = RequestMethod.GET)
	public Double sqr(@PathVariable(value = "number") String number) throws Exception {
		if (!isNumeric(number)) {
			throw new MathOperationException("Please, set a numeric value!");
		}
		
		Double sqr = (Double) Math.sqrt(convertToDouble(number));
		
		return sqr;
	}

}
