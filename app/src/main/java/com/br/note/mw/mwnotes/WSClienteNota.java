package com.br.note.mw.mwnotes;

import com.br.note.mw.mwnotes.com.br.mw.DAO.API.NotaDAO;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.sql.SQLException;

public class WSClienteNota implements NotaDAO {

    private SoapObject soap;
    private SoapSerializationEnvelope envelope;
    private HttpTransportSE http;
    private Object resposta;

    public WSClienteNota() {
        envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        http = new HttpTransportSE("http://192.168.15.10:8080/MWNWS/services/WebService?wsdl");
    }

    @Override
    public boolean insereNota(String notaJson) throws SQLException, IOException, XmlPullParserException {
        boolean retorno = false;

        soap = new SoapObject("http://WebService", "insereNota");
        soap.addProperty("notaJson", notaJson);

        envelope.setOutputSoapObject(soap);

        http.call("insereNota", envelope);

        resposta = envelope.getResponse();

        if (resposta.toString().equalsIgnoreCase("true")){
            retorno = true;
        }

        return retorno;
    }

    @Override
    public String achaNotaPorUsuario(String notaJson) throws IOException, XmlPullParserException {
        String retorno;

        soap = new SoapObject("http://WebService", "achaNotaPorUsuario");
        soap.addProperty("notaJson", notaJson);

        envelope.setOutputSoapObject(soap);

        http.call("achaNotaPorUsuario", envelope);

        resposta = envelope.getResponse();
        retorno = resposta.toString();

        return retorno;
    }

    @Override
    public String achaNotaPorTitulo(String notaJson) throws IOException, XmlPullParserException {
        String retorno;

        soap = new SoapObject("http://WebService", "achaNotaPorTitulo");
        soap.addProperty("notaJson", notaJson);

        envelope.setOutputSoapObject(soap);

        http.call("achaNotaPorTitulo", envelope);

        resposta = envelope.getResponse();
        retorno = resposta.toString();

        return retorno;
    }

    @Override
    public String achaTodos() {
        return null;
    }

    @Override
    public boolean atualizaNota(String notaJson) throws IOException, XmlPullParserException {
        boolean retorno = false;

        soap = new SoapObject("http://WebService", "atualizaNota");
        soap.addProperty("notaJson", notaJson);

        envelope.setOutputSoapObject(soap);

        http.call("atualizaNota", envelope);

        resposta = envelope.getResponse();

        if (resposta.toString().equalsIgnoreCase("true")){
            retorno = true;
        }

        return retorno;
    }

    @Override
    public boolean verificaNota(String notaJson) throws IOException, XmlPullParserException {
        boolean retorno = false;

        soap = new SoapObject("http://WebService", "verificaNota");
        soap.addProperty("notaJson", notaJson);

        envelope.setOutputSoapObject(soap);

        http.call("verificaNota", envelope);

        resposta = envelope.getResponse();

        if (resposta.toString().equalsIgnoreCase("true")){
            retorno = true;
        }

        return retorno;
    }

    @Override
    public boolean deletaNota(String notaJson) throws IOException, XmlPullParserException {
        boolean retorno = false;

        soap = new SoapObject("http://WebService", "deletaNota");
        soap.addProperty("notaJson", notaJson);

        envelope.setOutputSoapObject(soap);

        http.call("deletaNota", envelope);

        resposta = envelope.getResponse();

        if (resposta.toString().equalsIgnoreCase("true")){
            retorno = true;
        }

        return retorno;
    }

    @Override
    public String achaNotaPorCodigo(String notaJson) throws IOException, XmlPullParserException {
        String retorno;

        soap = new SoapObject("http://WebService", "achaNotaPorCodigo");
        soap.addProperty("notaJson", notaJson);

        envelope.setOutputSoapObject(soap);

        http.call("achaNotaPorCodigo", envelope);

        resposta = envelope.getResponse();
        retorno = resposta.toString();

        return retorno;
    }
}
