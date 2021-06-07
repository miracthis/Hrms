import Employer from "./pages/users/Employer";
import Candidate from "./pages/users/Candidate";
import Staff from "./pages/users/Staff";

export const routes = [
  {
    path: "/employer",
    exact: true,
    component: <Employer />,
    title: "Employer",
    isHeaderElement: true,
  },
  {
    path: "/candidate",
    exact: true,
    component: <Candidate/>,
    title: "Candidate",
    isHeaderElement: true,
  },
  {
    path: "/staff",
    exact: true,
    component: <Staff/>,
    title: "Staff",
    isHeaderElement: true,
  },
  
];