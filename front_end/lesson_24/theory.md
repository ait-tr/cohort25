### React Router

React Router — библиотека для работы с маршрутами в React.
React Router DOM — обёртка для React Router в веб-приложениях

### Декларативная маршрутизация
Декларативная маршрутизация — это стиль кодирования, используемый в React и React Router. Декларативные маршруты React являются компонентами и используют ту же инфраструктуру, что и любое приложение React. 
Эти маршруты связывают веб-адреса с определенными страницами и другими компонентами, используя мощный механизм рендеринга React и условную логику для программного включения и выключения маршрутов.

#### Чтобы установить пакет введите команду:
```npm i react-router-dom```

### Настройка приложения
```
import { BrowserRouter } from 'react-router-dom';

...

  <BrowserRouter>
    <App />
  </BrowserRouter>

```

```
import { Route, Routes } from 'react-router-dom';
...
function App(): JSX.Element {
return (
    <Routes>
        <Route path="/" element={<Layout />}>
            <Route path="/counter" element={<Counter />} />
            <Route path="/" element={<HomePage />} />
        </Route>
    </Routes>
);
}
```
```
import React from 'react';
import { Outlet } from 'react-router-dom';
import Navbar from '../componets/Navbar/Navbar';

export default function Layout(): JSX.Element {
    return (
        <>
            <Navbar />
            <Outlet />
        </>
    );
}
```

