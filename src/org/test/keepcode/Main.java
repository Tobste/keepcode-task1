package org.test.keepcode;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder content = getContent("https://onlinesim.ru/api/getFreePhoneList");

        List<Object> rawPhones = new JSONObject(content.toString()).getJSONArray("numbers").toList();
        List<Phone> phones = parse(rawPhones);
        BigInteger i = BigInteger.valueOf(1);
        for (Phone phone : phones) {
            System.out.println("Запись номер: " + i);
            System.out.println("Номер " + phone.getNumber());
            System.out.println("Время обновления: " + phone.getUpdate());
            System.out.println("Представление в человеческом варианте " + phone.getDateHumans());
            System.out.println("Активировано до: " + phone.getMaxDate());
            System.out.println("Код страны " + phone.getCountry().getCode());
            System.out.println("Название страны " + phone.getCountry().getName());
            i = i.add(BigInteger.valueOf(1));
        }

    }

    public static List<Phone> parse(List<Object> rawPhones) {
        List<Phone> parsePhones = new ArrayList<>();
        for (Object rawPhone : rawPhones) {
            Map<String, String> formatRawPhone = (Map<String, String>) rawPhone;
            String text = String.valueOf(formatRawPhone.get("country"));
            parsePhones.add(new Phone(formatRawPhone.get("number"), formatRawPhone.get("updated_at"), formatRawPhone.get("data_humans"), formatRawPhone.get("full_number"), formatRawPhone.get("maxdate"), Objects.equals(formatRawPhone.get("disabled"), "enabled"), new Country(String.valueOf(formatRawPhone.get("country")), formatRawPhone.get("country_text"))));
        }
        return parsePhones;
    }

    public static StringBuilder getContent(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        StringBuilder content;

        try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            content = new StringBuilder();
            while ((line = input.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        } finally {
            connection.disconnect();
        }
        return content;
    }
}
