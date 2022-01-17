package com.algaworks.algalog.domain.exception;




public class EntidadeNaoEncontradaException extends NegocioException
{
    private static final long serialVersionUID = -1062138421589651833L;

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
