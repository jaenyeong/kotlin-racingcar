package calculator

data class MathExpression(
    private val _operands: List<Operand>,
    private val _operators: List<Operator>
) {
    init {
        require(assertValidOperandSizeAndOperatorSize())
    }

    private fun assertValidOperandSizeAndOperatorSize(): Boolean {
        val isValidOperandSize = _operands.size >= REQUIRED_OPERAND_MIN_SIZE
        val isValidOperatorsSize = _operators.size >= REQUIRED_OPERATOR_MIN_SIZE
        val isValidExpressionSize = _operands.size == _operators.size + IS_ONE_SMALLER_THAN_OPERAND_SIZE

        return isValidOperandSize && isValidOperatorsSize && isValidExpressionSize
    }

    val operands: List<Operand>
        get() = _operands.toList()
    val operators: List<Operator>
        get() = _operators.toList()
    val operatorsSize: Int
        get() = _operators.size

    companion object {
        private const val REQUIRED_OPERATOR_MIN_SIZE = 1
        private const val REQUIRED_OPERAND_MIN_SIZE = 2
        private const val IS_ONE_SMALLER_THAN_OPERAND_SIZE = 1
    }
}
