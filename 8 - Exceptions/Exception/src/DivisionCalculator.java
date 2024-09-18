public class DivisionCalculator {

    // Método para dividir dois números com tratamento de exceção padrão
    public int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        }
        return numerator / denominator;
    }

    // Método que demonstra exceção customizada
    public void validateNumber(int number) throws CustomException {
        if (number < 0) {
            throw new CustomException("Número negativo não é permitido: " + number);
        }
        System.out.println("Número validado: " + number);
    }
}
