import React, { useState, FC } from "react";
import { useDispatch } from "react-redux";
import { fetchWeather } from "../redux/weatherSlice";

const WeatherForm: FC = (): JSX.Element => {
    const [city, setCity] = useState('');
    const dispatch = useDispatch();

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        // Отключаем дефолтное поведение тэга (form)
        e.preventDefault();
        dispatch(fetchWeather(city));
        setCity('');
    }

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                placeholder="Enter city name"
                // Ниже двусторонняя связка состояния и input
                onChange={(e) => setCity(e.target.value)}
                value={city}
            />
            <button type="submit">Get weather</button>
        </form>
    );
};

export default WeatherForm;
