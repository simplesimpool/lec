import { useNavigate } from "react-router-dom";

export default function Header() {
  const navigate = useNavigate(); 

  return (
    <>
      <div style={{display: 'inline-block', border: '1px solid black'}}>
        <button onClick={() => navigate('/courses')}>강좌</button>
        <button onClick={() => navigate('/boards')}>게시판</button>
        <button onClick={() => navigate('/chats')}>채팅방</button>
      </div>
    </>
  );
}