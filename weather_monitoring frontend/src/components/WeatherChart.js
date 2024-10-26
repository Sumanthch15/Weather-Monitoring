import React from 'react';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';

const WeatherChart = ({ data }) => (
  <ResponsiveContainer width="100%" height={400}>
    <LineChart data={data}>
      <CartesianGrid strokeDasharray="3 3" />
      <XAxis dataKey="city" label={{ value: "City", position: "insideBottomRight", offset: -5 }} />
      <YAxis label={{ value: "Temperature (°C)", angle: -90, position: "insideLeft" }} />
      <Tooltip />
      <Legend />
      <Line type="monotone" dataKey="temperature" name="Temperature" stroke="#8884d8" activeDot={{ r: 8 }} />
      <Line type="monotone" dataKey="feelsLike" name="Feels Like" stroke="#82ca9d" />
    </LineChart>
  </ResponsiveContainer>
);

export default WeatherChart;
