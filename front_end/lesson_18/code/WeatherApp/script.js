const weatherBlock = document.getElementById('weather');
const urlGetLocation = "https://get.geojs.io/v1/ip/geo.json"; 
const urlGetWeather = "https://api.open-meteo.com/v1/forecast?";


weatherHandler(getLocation,getWeather,show);


function show(weather){
    document.getElementById('city').innerText=weather.city;
    document.getElementById('temperature').innerText=weather.temperature+"°C";
    document.getElementById('windspeed').innerText=weather.windspeed+" km/h";
    document.getElementById('weathercode').innerText=weather.description;
    document.getElementById('main_icon').setAttribute('src','./images/'+ getIconByWeatherCode(weather.weathercode));
    console.log(getIconByWeatherCode(weather.weathercode));
    console.log(weather.weathercode);

  }


async function getLocation(){
    try{
        const response = await fetch(urlGetLocation);
        const data = await response.json();
        return {city:data.city,
                longitude: data.longitude,
                latitude:data.latitude };
    } catch {
        throw new Error("error while get location");
    }   

}

async function getWeather(location){
    try{      
        const{city,longitude,latitude} = location;
        /* 
        const{city,longitude,latitude} = location;   
                is the same like:
        const city= location.city;
        const longitude = location.longitude;
        const latitude = location.latitude;
        */
        const response = await fetch(urlGetWeather + `latitude=${latitude}&longitude=${longitude}&current_weather=true`);
        console.log(urlGetWeather+`latitude=${latitude}&longitude=${longitude}&current_weather=true`);
        const data = await response.json();
        return {city:city,
                longitude:longitude,
                latitude:latitude,
                temperature: data.current_weather.temperature,  
                windspeed: data.current_weather.windspeed,  
                winddirection: data.current_weather.winddirection,  
                weathercode: data.current_weather.weathercode,
                time:data.current_weather.time, 
                description:getWeatherDescription(data.current_weather.weathercode)
            };
    } catch {
        throw new Error("error while get weather");
    }   
}


async function weatherHandler(getLocationFunction, getWeatherFunction, showFunction){
    const location = await getLocationFunction();
    const weater= await getWeatherFunction(location);
    showFunction(weater);
}

function getIconByWeatherCode(code){
    let picName;
    switch(code){
        case 0:
        case 1:picName='sunny.png';break;
        case 2:
        case 3:picName='sunwithclouds.png';break;
        case 45: case 48: case 51: case 53: case 55: case 56: case 57:picName='clouds.png';break;    
        case 61: case 63: case 65: case 66: case 67: case 80: case 81:  case 82:picName='rain.png';break;    
        case 71: case 73: case 75: case 85: case 86:picName='snow.png';break;    
        case 95: case 96: case 99:picName='groza.png';break;
        default:picName= 'weather.png';   
    }
    return picName;
}

function getWeatherDescription(weatherCode) {
    const weatherDescriptions = {
      0: 'Clear sky',
      1: 'Mainly clear',
      2: 'Partly cloudy',
      3: 'Overcast',
      45: 'Fog',
      48: 'Depositing rime fog',
      51: 'Light drizzle',
      53: 'Moderate drizzle',
      55: 'Drizzle: dense',
      56: 'Freezing drizzle: light',
      57: 'Freezing drizzle: dense',
      61: 'Rain: slight',
      63: 'Rain: moderate',
      65: 'Rain: heavy',
      66: 'Freezing rain: light',
      67: 'Freezing rain: heavy',
      71: 'Snow fall: slight',
      73: 'Snow fall: moderate',
      75: 'Snow fall: heavy',
      77: 'Snow grains',
      80: 'Rain showers: slight',
      81: 'Rain showers: moderate',
      82: 'Rain showers: violent',
      85: 'Snow showers: slight',
      86: 'Snow showers: heavy',
      95: 'Thunderstorm',
      96: 'Thunderstorm with slight hail',
      99: 'Thunderstorm with heavy hail',
    };
  
    return weatherDescriptions[weatherCode] || 'Unknown';
  }
  














