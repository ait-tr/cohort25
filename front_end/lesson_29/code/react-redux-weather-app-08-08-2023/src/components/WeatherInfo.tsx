import React from "react";
import { useSelector } from "react-redux";
import { RootState } from "../redux/store";

const WeatherInfo: React.FC = (): JSX.Element | null => {
    const { data, error, loading } = useSelector((state: RootState) => state.weather);
    
    if (loading) {
        return <div>Loading...</div>
    }

    if (error) {
        return <div>Error: {error}</div>
    }

    if (!data) {
        return null;
    }

    return (
        <div>
            <h2>Weather information:</h2>
            <p>City: {data.name}</p>
            <p>Temperature: {(data.main.temp - 273.15).toFixed(1)} &#8451;</p>
            <p>Description: {data.weather[0].description}</p>
        </div>
    );
};

export default WeatherInfo;
