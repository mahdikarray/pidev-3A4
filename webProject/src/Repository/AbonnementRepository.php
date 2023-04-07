<?php
namespace App\Repository;

use App\Entity\Abonnement;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;


/**
 * @method Abonnement|null find($id, $lockMode = null, $lockVersion = null)
 * @method Abonnement|null findOneBy(array $criteria, array $orderBy = null)
 * @method Abonnement[]    findAll()
 * @method Abonnement[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class AbonnementRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Abonnement::class);
    }

    public function create(Abonnement $abonnement): void
    {
        $this->_em->persist($abonnement);
        $this->_em->flush();
    }

    public function read(int $id): ?Abonnement
    {
        return $this->find($id);
    }

    public function update(Abonnement $abonnement): void
    {
        $this->_em->flush();
    }

    public function delete(Abonnement $abonnement): void
    {
        $this->_em->remove($abonnement);
        $this->_em->flush();
    }
    public function checkOffreExists(int $idOffre): bool
    {
        return $this->offreRepository->find($idOffre) !== null;
    }
}