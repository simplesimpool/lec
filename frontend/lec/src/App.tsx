import { Routes, Route } from 'react-router-dom';

import Header from './components/Header';
import Footer from './components/Footer';

import Main from './pages/Main';
import Course from './pages/Course';
import Board from './pages/Board';
import Chat from './pages/Chat';

export default function App() {
  return (
    <>
      <Header />
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/courses" element={<Course />} />
        <Route path="/boards" element={<Board />} />
        <Route path="/chats" element={<Chat />} />
      </Routes>
      <Footer />
    </>
  );
}