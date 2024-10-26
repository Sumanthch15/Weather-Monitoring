import React, { useEffect, useState } from 'react';
import axios from 'axios';
import WeatherChart from './components/WeatherChart';

const App = () => {
  const [weatherData, setWeatherData] = useState([]);
  const [error, setError] = useState(null);
  const cities = ["Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"];
  const apiKey = "5c4450f547eadce7b54472f54e29a258";

  useEffect(() => {
    const fetchWeatherData = async () => {
      try {
        // Create an array of API requests for each city
        const requests = cities.map(city =>
          axios.get(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}`)
        );

        // Wait for all requests to complete
        const responses = await Promise.all(requests);

        // Format and combine the data from each response
        const formattedData = responses.map(response => {
          const data = response.data;
          return {
            city: data.name, // City name for X-axis
            temperature: data.main.temp - 273.15, // Convert Kelvin to Celsius
            feelsLike: data.main.feels_like - 273.15, // Convert Kelvin to Celsius
            mainCondition: data.weather[0].main, // Main weather condition
            timestamp: new Date(data.dt * 1000).toLocaleString(), // Convert Unix timestamp to date
          };
        });

        setWeatherData(formattedData);
      } catch (error) {
        console.error("Error fetching weather data:", error);
        setError("Failed to fetch weather data. Please try again later.");
      }
    };

    fetchWeatherData();
  }, []);

  return (
    <div>
      <h1>Weather Monitoring System</h1>
      {error && <p>{error}</p>}
      {!error && <WeatherChart data={weatherData} />}
    </div>
  );
};

export default App;
